package com.company.drag;



import com.company.commandServer.Command;
import com.company.data.StorageManager;
import com.company.utily.CommandLine;

import java.time.LocalDateTime;

public class CreatDragon extends Dragon implements Command {

    CommandLine CL;

    public CommandLine execute(CommandLine commandLine) {
        this.CL = commandLine;

        // первоначальный вход если дракон не создавался
        if (CL.dragonID == 0) {
            Dragon dragon = new Dragon();
            long id = ID.generateID();
            dragon.setId(id);
            CL.dragonID = id;
            StorageManager.putDragon(id, dragon);

            CL.serverWaitForAnswer = true;
            CL.servAnswer = "show me parameters for creation";
            CL.needArgs = true;
            return CL;
        }
        // вторичный вход, дракон создан, но без параметров

//         создаем параметры, которые нам пришли
        Dragon dragon = creation();

        CL.serverWaitForAnswer = false;
        CL.servAnswer = dragon.toString();
        CL.needArgs = false;
//        CL.args.clear();
        StorageManager.putDragon(CL.dragonID, dragon);
        CL.dragonID = 0;
        return CL;

    }

    Dragon creation() {

        Dragon dragon = StorageManager.getDragon(CL.dragonID);

        String name = CL.args.get(0);
        Coordinates coordinates = new Coordinates(CL.args.get(1), CL.args.get(2));
        LocalDateTime creationDate = LocalDateTime.now();
        Integer age = Integer.parseInt(CL.args.get(3));
        Color color = Color.valueOf(CL.args.get(4).toUpperCase());
        DragonType type = DragonType.valueOf(CL.args.get(5).toUpperCase());
        DragonCharacter character = DragonCharacter.valueOf(CL.args.get(6).toUpperCase());
        DragonCave cave = new DragonCave(Long.parseLong(CL.args.get(7)));

        dragon.setClientName(CL.clientName);
        dragon.setName(name);
        dragon.setCoordinates(coordinates);
        dragon.setCreationDate(creationDate);
        dragon.setAge(age);
        dragon.setColor(color);
        dragon.setType(type);
        dragon.setCharacter(character);
        dragon.setCave(cave);

        return dragon;
    }
}