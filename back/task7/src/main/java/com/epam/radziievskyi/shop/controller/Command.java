package com.epam.radziievskyi.shop.controller;

import java.io.IOException;
import java.text.ParseException;

public interface Command {

    void execute() throws ParseException, IOException;

}