// Pandyaka Aptanagi / 13517003

/* Kelas GraphIsland berisi dengan representasi Graph dengan menggunakan 
   tipe data List of LinkedList, dengan index dari List merepresentasikan
   pulau dan isi dari LinkedList merepresentasikan pulau tersebut memiliki
   bridge ke arah pulau mana.
   
   List dipilih karena lebih menguntungkan dibandingkan dengan menggunakan
   array of Linked List.

   Linked List digunakan karena lebih cocok untuk merepresentasikan pulau 
   yang terhubung dibandingkan dengan List biasa. Juga karena bisa menampung
   lebih banyak daripada dengan menggunakan array biasa. */

import java.util.*;

public class GraphIsland
    {
        // ATRIBUT

        private int Vertices;
        public List<LinkedList<Integer>> list_island;

        // METHOD

        public GraphIsland(int v)
        /* Konstruktor untuk Graph Island, berisi deklarasi pembentukan objek List of LinkedList
           dan inisialisasi untuk setiap elemennya dengan size v, yakni sebanyak pulau yang 
           dimainkan oleh pengguna */
    
            {
                Vertices = v;
                list_island = new ArrayList<LinkedList<Integer>>();
                for (int i = 0 ; i < Vertices ; i++)
                    {
                        LinkedList<Integer> newlink = new LinkedList<>();
                        list_island.add(i,newlink);
                    }
            }
        
        public void addEdge(int v, int w)
        /* Fungsi addEdge, untuk menambahkan simpul baru pada list yang sudah ada
           menggunakan fungsi get dan add dari bawaan List dan LinkedList, ide utamanya
           adalah dengan menambahkan simpul w pada index v pada list */
            
            {
                list_island.get(v).add(w);
            }
    }