package com.epam.ld.module2.testing;

import picocli.CommandLine;

import com.epam.ld.module2.testing.cli.CommandLineInterface;

public class MainEntryPoint {

    public static void main(String[] args) {
        CommandLine.run(new CommandLineInterface(), args);
    }

}
