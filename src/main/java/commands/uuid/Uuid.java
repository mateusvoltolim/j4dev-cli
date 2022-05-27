package commands.uuid;

import commands.Constants;
import commands.BasicCommand;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

import java.util.UUID;
import java.util.stream.IntStream;

/**
 * @author Mateus N V Satelis
 * @since 15/05/2022
 */
@Command(name = "uuid", description = "Generate UUID", mixinStandardHelpOptions = true)
public class Uuid implements BasicCommand {

    @Option(names = {"-n"}, description = "How many UUID should be generated", defaultValue = "1")
    Integer quantity;

    @Override
    public Integer call() {
        if (quantity < 0) {
            quantity = 1;
        }

        IntStream.rangeClosed(0, quantity).forEach($ -> System.out.println(UUID.randomUUID()));
        return Constants.SUCCESS;
    }
}
