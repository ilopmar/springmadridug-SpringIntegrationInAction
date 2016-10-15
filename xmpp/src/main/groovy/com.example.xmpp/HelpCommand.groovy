package com.example.xmpp

class HelpCommand implements XmppDemoCommand {

    @Override
    String execute() {
        return """
        Commands available:
          stock QUOTE1 QUOTE2 ... QUOTEN
          weather CITY
        Example:
          stock GOOG AAPL YHOO
          weather london
        """
    }
}
