class DataInfo {
    interface Local {
        DataInfo[] loadDB(String filename);
    }

    interface Remote extends Local {
        void connect2WWW(String url);
    }

    class LocalMode implements Local {
        public DataInfo[] loadDB(String name) {
            System.out.println("Load from a local data");
            return null;
        }
    }

    class RemoteMode implements Remote {
        void connect2WWW(String url) {
            System.out.println("Connect to a remote site");
        }
        public DataInfo[] loadDB(String name) {
            System.out.println("Load from a remote database");
            return null;
        }
    }

    // The Abstrac Factory
    interface ConnectionFactory {
        Local getLocalConnection();
        Remote getRemoteConnect();
    }

    class DataManager implements ConnectionFactory {
        boolean local = false;
        DataInfo[] data;
        //...
        public Remote getRemoteConnect() {
            return new RemoteMode();
        }
        public Local getLocalConnection() {
            return new LocalMode();
        }
        public void loadData() {
            if(local) {
                Local conn = getLocalConnection();
                data = conn.loadDB("db.db");
            } else {
                Remote conn = getRemoteConnect();
                conn.connect2WWW("www.some.where.com");
                data = conn.loadDB("db.db");
            }
        }
    }
}