// Pandyaka Aptanagi / 13517003

/* Kelas LonelyIsland, merupakan kelas yang menggunakan kelas
   GraphIsland, kemudian menggunakan algoritma DFS (Depth First Searching)
   untuk mencari solusi dari permasalahan LonelyIsland */

import java.util.*;
import java.io.*;

public class LonelyIsland
    {
        // ATRIBUT
        private int island,bridges,startIsland;
        private GraphIsland graph_island;
        private List<Integer> ListVisited;
        private Set<Integer> ListLonely;
        private boolean isNotLonely;

        // METHOD

        public LonelyIsland()
        /* Merupakan konstruktor dari kelas LonelyIsland, menggunakan 
           reader untuk file eksternal, kemudian dibuat objek GraphIsland
           dengan input tersebut */
            {
                File input_file = new File("input.txt");
                
                try 
                    {
                        Scanner file_reader = new Scanner(input_file);

                        island = file_reader.nextInt();
                        bridges = file_reader.nextInt();
                        startIsland = file_reader.nextInt();

                        graph_island = new GraphIsland(island+1);

                        for (int i = 0 ; i < bridges ; i++)
                            {
                                int x = file_reader.nextInt();
                                int y = file_reader.nextInt();

                                graph_island.addEdge(x,y);
                            }
                    }
                catch (Exception e) 
                    {
                        System.out.println("File tidak ditemukan!");
                    }
            }
        
        public boolean isVisited(int idx, List<Integer> list_isl)
        /* Fungsi untuk melakukan pengecekan apakah sebuah pulau sudah dikunjungi
           atau belum, menggunakan algoritma searching untuk mencari sebuah nilai di 
           dalam list */
            {
                boolean visited = false;
                int i = 0;
                while ( i < list_isl.size() && visited == false)
                    {
                        if (list_isl.get(i) == idx)
                            {
                                visited = true;
                            }
                        else
                            {
                                i = i + 1;
                            }
                    }
                
                return visited;
            }
        
        public void Solution(int start , List<Integer> list_visited, Set<Integer> list_hasil)
        /* Representasi solusi untuk permasalahan ini, menggunakan algoritma DFS (Depth First Searching),
           menyimpan hasil dari pulau yang tidak bisa berpindah lagi pada list_hasil, dan menyimpan jalan 
           ke pulau tersebut dalam list_visited */
            {
                list_visited.add(start);
                isNotLonely = false;

                for (int i : graph_island.list_island.get(start))
                    {
                        if (!isVisited(i, list_visited))
                            {
                                Solution(i, list_visited, list_hasil);
                                isNotLonely = true;
                                list_visited.remove(list_visited.size()-1);
                            }
                    }   
                
                if (!isNotLonely)
                    {
                        list_hasil.add(start);
                        printJalan(list_visited);
                        System.out.println();    
                    }
            }

        public void Solve()
        /* Fungsi untuk melakukan penyelesaian dengan memanggil fungsi Solution,
           akan mengeluarkan hasil pulau yang tidak bisa dikunjungi lagi */
            {
                ListVisited = new ArrayList<Integer>();
                ListLonely = new TreeSet<Integer>();

                Solution(startIsland, ListVisited, ListLonely);
            }
        
        public void printJalan(List<Integer> list_visited)
        /* Fungsi untuk mengeluarkan kemungkinan jalan
           yang sudah tersimpan dalam sebuah list of integer */
            {
                System.out.print("\t [");
                for (int i = 0 ; i < list_visited.size() ; i++)
                    {
                        System.out.print(list_visited.get(i));
                        if ( i < list_visited.size()-1)
                            {
                                System.out.print(" to ");
                            }
                    }
                System.out.print("]");
                System.out.println();
            }
        
        public void printSoal()
        /* Fungsi untuk mengeluarkan jumlah pulau, jumlah bridges
           dan start Island, digunakan untuk program utama */
            {
                System.out.print("\t [->] Island(s) : " );
                System.out.println(island);

                System.out.print("\t [->] Bridge(s) : ");
                System.out.println(bridges);

                System.out.print("\t [->] Start Island : ");
                System.out.print(startIsland);
                System.out.println();

                System.out.println();
                System.out.println("\t Island Source | Island Destination");
                for (int i = 0 ; i < graph_island.list_island.size() ; i++)
                    {
                        if ( i != 0)
                            {
                                System.out.print("\t " + (i) + " = ");
                                System.out.println(graph_island.list_island.get(i));
                            }
                    }
            }

        public void letsPlay()
        /* Fungsi utama yang akan dipanggil pada main program */
            {
                printSoal();
                System.out.println();

                System.out.println("\t The possible way(s) : ");
                double startTime = System.nanoTime();
                Solve();
                double endTime = System.nanoTime();
                System.out.println();

                System.out.print("\t Lonely Island(s) : ");
                System.out.println(ListLonely);
                System.out.println();

                System.out.println("\t Time needed : " + (endTime-startTime)/1000000000 + " seconds.");
                System.out.println();
            }
    }