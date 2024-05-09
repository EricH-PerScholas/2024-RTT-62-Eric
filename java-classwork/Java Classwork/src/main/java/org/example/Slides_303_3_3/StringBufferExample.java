package org.example.Slides_303_3_3;

public class StringBufferExample {

    public static void main(String[] args) {

        // NOTE : the 2nd argument is not inclusive of the position
        // NOTE : run this in the debugger to see what each statement is doing
        // NOTE : for the KBA use a piece of blank scratch paper to write the string down after each operation

        // 012345678901
        // filename.txt
        StringBuffer sb = new StringBuffer("filename.txt");
        sb.insert(0,"new_");

        // 0123456789012345
        // new_filename.txt
        System.out.println(sb);

        sb.replace(0, 4, "old_");

        // 0123456789012345
        // old_filename.txt
        System.out.println(sb);

        // the thing to memorize for the KBA .. is .. that ...
        // replace is going first delete the items from 0 to 4 then insert the string at position start
        sb.replace(0, 4, "very_old_");

        // 0123456789012345
        // very_old_filename.txt
        System.out.println(sb);

        sb.reverse();

        // 0123456789012345
        // txt.emanelif_dlo_yrev
        System.out.println(sb);

        sb.delete(0, 4);

        // 0123456789012345
        // emanelif_dlo_yrev
        System.out.println(sb);
    }

}
