package com.example.Tambola.service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Tambola.repository.TambolaRepository;


@Service
public class TambolaService {

    @Autowired
    private TambolaRepository tambolaRepository;

    

    // public int[][] generateTambolaTicket() {
    //     int[][] ticket = new int[3][9];
    //     Map<Integer, ArrayList<Integer>> columnNumbers = new HashMap<>();
    //     Random random = new Random();

    //     for (int i = 0; i < 9; i++) {
    //         ArrayList<Integer> numbers = new ArrayList<>();
    //         int start = i * 10 + 1;
    //         int end = start + 10; 
    //         for (int j = start; j < end; j++) {
    //             numbers.add(j);
    //         }
    //         columnNumbers.put(i, numbers);
    //     }

    //     for (int col = 0; col < 9; col++) {
    //         ArrayList<Integer> numbers = columnNumbers.get(col);
    //         if (numbers.size() > 0) {
    //             int row = random.nextInt(3);
    //             ticket[row][col] = numbers.remove(random.nextInt(numbers.size()));
    //         }
    //     }

    //     for (int row = 0; row < 3; row++) {
    //         ArrayList<Integer> columns = new ArrayList<>();
    //         for (int col = 0; col < 9; col++) {
    //             if (ticket[row][col] != 0) {
    //                 columns.add(col);
    //             }
    //         }

    //         while (columns.size() < 5) {
    //             int col;
    //             do {
    //                 col = random.nextInt(9);
    //             } while (columns.contains(col) || ticket[0][col] != 0 && ticket[1][col] != 0 && ticket[2][col] != 0);

    //             ArrayList<Integer> numbers = columnNumbers.get(col);
    //             if (numbers.size() > 0) {
    //                 ticket[row][col] = numbers.remove(random.nextInt(numbers.size()));
    //                 columns.add(col);
    //             }
    //         }
    //     }

    //     return ticket;
    // }

    public String[][] generateTambolaTicket() {
        String[][] ticket = new String[3][9];
        Map<Integer, ArrayList<Integer>> columnNumbers = new HashMap<>();
        Random random = new Random();

        for (int i = 0; i < 9; i++) {
            ArrayList<Integer> numbers = new ArrayList<>();
            int start = i * 10 + 1;
            int end = start + 10; 
            for (int j = start; j < end; j++) {
                numbers.add(j);
            }
            columnNumbers.put(i, numbers);
        }

        for (int col = 0; col < 9; col++) {
            ArrayList<Integer> numbers = columnNumbers.get(col);
            if (numbers.size() > 0) {
                int row = random.nextInt(3);
                ticket[row][col] = String.valueOf(numbers.remove(random.nextInt(numbers.size())));
            }
        }

        for (int row = 0; row < 3; row++) {
            ArrayList<Integer> columns = new ArrayList<>();
            for (int col = 0; col < 9; col++) {
                if (ticket[row][col] != null) {
                    columns.add(col);
                }
            }

            while (columns.size() < 5) {
                int col;
                do {
                    col = random.nextInt(9);
                } while (columns.contains(col) || 
                         (ticket[0][col] != null && ticket[1][col] != null && ticket[2][col] != null));

                ArrayList<Integer> numbers = columnNumbers.get(col);
                if (numbers.size() > 0) {
                    ticket[row][col] = String.valueOf(numbers.remove(random.nextInt(numbers.size())));
                    columns.add(col);
                }
            }
        }

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 9; col++) {
                if (ticket[row][col] == null) {
                    ticket[row][col] = " ";
                }
            }
        }

        return ticket;
    }

  
}


