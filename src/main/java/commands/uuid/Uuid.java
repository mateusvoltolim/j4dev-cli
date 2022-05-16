package commands.uuid;

import commands.Constants;
import commands.BasicCommand;
import picocli.CommandLine.Command;

import java.util.UUID;

/**
 * @author Mateus N V Satelis
 * @since 15/05/2022
 */
@Command(name = "uuid", description = "Generate UUID")
public class Uuid implements BasicCommand {

    @Override
    public Integer call() {
        System.out.println(UUID.randomUUID());
        return Constants.SUCCESS;
    }
}
