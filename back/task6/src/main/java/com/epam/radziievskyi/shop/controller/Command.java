package com.epam.radziievskyi.shop.controller;

import java.text.ParseException;

public interface Command {

    void execute() throws ParseException;

}