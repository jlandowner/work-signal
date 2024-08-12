final class Signal {
    private static void wait(String title, int max) {
        for (int i = 0; i <= max; i++) {
            System.out.println(String.format("%s: THIS IS LOOP %d", title, i));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("start java");
        
        long pid = ProcessHandle.current().pid();
        System.out.println(String.format("kill -15 %d", pid));
    
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("shutdown start");
            wait("shutdown", 5);
            System.out.println("shutdown finished");
        }));

        wait("main", 30);
        System.out.println("end java");
    }
}
