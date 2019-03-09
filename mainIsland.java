// Pandyaka Aptanagi / 13517003

/* Kelas main, yang akan digunakan untuk bermain pada ]
   permainan ini */

public class mainIsland
    {
        public static void main(String[] args)
            {
                new Thread (null, new Runnable()
                    {
                        public void run()
                            {
                                new mainIsland().run();
                            }
                    }
                , "To avoid StackOverFlow", 1<<64).start();
            }

        public void run()
            {
                    // Kamus Lokal
                    LonelyIsland newlon = new LonelyIsland();

                    // Algoritma
                    System.out.println();
                    System.out.println("\t ======== SELAMAT DATANG DI LONELY-ISLAND GAME ========");
                    System.out.println();
                    newlon.letsPlay();
            }
    }