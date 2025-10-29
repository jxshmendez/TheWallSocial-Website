package org.josh.climber.model;

public enum ResultType {
    SEND,        // successfully completed the climb
    FALL,        // fell off before finishing
    PROJECT,     // still working on it
    FLASH,       // completed on first attempt
    ONSIGHT,     // completed without prior knowledge
    FAIL
}

