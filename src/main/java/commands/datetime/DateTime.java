package commands.datetime;

import commands.BasicCommand;
import commands.Constants;
import utils.Strings;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author Mateus N V Satelis
 * @since 15/05/2022
 */
@Command(name = "dt", aliases = {"datetime"}, description = "Date/Time functions")
public class DateTime implements BasicCommand {

    @Option(names = {"-z", "--zone"}, description = "It specifies which zone id should be used", defaultValue = "")
    String zone;

    @Command(name = "-from-epoch", description = "Convert to human readable date/time")
    Integer fromEpoch(
            @Option(names = {"-ms", "--milliseconds"}, description = "If epoch is milliseconds", defaultValue = "false") Boolean ms,
            @Parameters(index = "0", description = "Epoch", arity = "1") Long epoch
    ) {
        final var instant = ms ? Instant.ofEpochMilli(epoch) : Instant.ofEpochSecond(epoch);
        final var zoneId = zone.isBlank() ? ZoneId.systemDefault() : ZoneId.of(zone);
        System.out.println(ZonedDateTime.ofInstant(instant, zoneId));
        return Constants.SUCCESS;
    }

    @Command(name = "-from-dt", description = "Convert to epoch timestamp")
    Integer fromDateTime(
            @Option(names = {"-ms", "--milliseconds"}, description = "If epoch output should be in milliseconds", defaultValue = "false") Boolean ms,
            @Option(names = {"-f", "--format"}, description = "Date/Time Format", defaultValue = "") String format,
            @Parameters(index = "0", description = "Date/Time", arity = "1") String dateTime
    ) {
        final var zdt = format.isBlank() ? ZonedDateTime.parse(dateTime) : ZonedDateTime.parse(dateTime, DateTimeFormatter.ofPattern(format));
        final var epoch = ms ? zdt.toInstant().toEpochMilli() : zdt.toEpochSecond();
        System.out.println(epoch);
        return Constants.SUCCESS;
    }

    @Override
    public Integer call() {
        final var zdt = Strings.defaultIfBlank(zone).isBlank() ? ZonedDateTime.now() : ZonedDateTime.now(ZoneId.of(zone));
        System.out.printf("Epoch (s):       %s\n", zdt.toEpochSecond());
        System.out.printf("Epoch (ms):      %s\n", zdt.toInstant().toEpochMilli());
        System.out.printf("Human Readable:  %s\n", zdt);
        return Constants.SUCCESS;
    }
}
