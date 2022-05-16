import commands.datetime.DateTime;
import handlers.GeneralExecutionExceptionHandler;
import commands.uuid.Uuid;
import picocli.CommandLine;
import picocli.CommandLine.Command;

/**
 * @author Mateus N V Satelis
 * @since 15/05/2022
 */
public class J4DevCliMain {
    @Command(mixinStandardHelpOptions = true)
    static class J4Dev {
    }

    public static void main(String[] args) {
        System.exit(
                new CommandLine(new J4Dev())
                        .setExecutionExceptionHandler(new GeneralExecutionExceptionHandler())
                        .addSubcommand(new Uuid())
                        .addSubcommand(new DateTime())
                        .execute(args));
    }

}
