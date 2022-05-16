package handlers;

import commands.Constants;
import picocli.CommandLine;
import picocli.CommandLine.IExecutionExceptionHandler;
import picocli.CommandLine.ParseResult;

/**
 * @author Mateus N V Satelis
 * @since 15/05/2022
 */
public class GeneralExecutionExceptionHandler implements IExecutionExceptionHandler {

    @Override
    public int handleExecutionException(Exception ex, CommandLine commandLine, ParseResult parseResult) {
        System.err.println(ex.getMessage());
        return Constants.FAILURE;
    }
}
