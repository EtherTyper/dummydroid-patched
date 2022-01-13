package de.onyxbits.raccoon.standalone.cli;

import de.onyxbits.raccoon.standalone.SystemProperties;

public interface CommandlineSystemProperties extends SystemProperties {
   String SP_REDIRECT_OUT = "raccoon.cli.silent.out";
   String SP_REDIRECT_ERR = "raccoon.cli.silent.err";
}
