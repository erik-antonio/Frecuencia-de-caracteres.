public static void main(String[] args) {
        //Almacenamiento
        String words = "a-b-c-d-e-f-g-h-i-j-k-l-m-n-ñ-o-p-q-r-s-t-u-v-w-x-y-z-,-.-:-;";
        String[][] table = new String[31][2];
        String[] aux = words.split("-");
        for (int i = 0; i < aux.length; i++) {
            table[i][0] = aux[i];
            table[i][1] = "0";
        }
        //Lectura del archivo
        String ruta = "C:\\Users\\rodol\\Downloads\\el_quijote.txt";
        String linea;
         try {
            BufferedReader lector = new BufferedReader(new FileReader(ruta));
            while ((linea = lector.readLine()) != null) {    
                //Escaneo de lineas
                linea =  linea.toLowerCase();
                linea = quitarAcentos(linea);
                escanear(linea, table, words);
            }
             for (int i = 0; i < table.length; i++) {
                 System.out.println(table[i][0] + " | " + table[i][1]);
             }
        } catch (FileNotFoundException ex) {
            System.err.println(ex.getMessage());
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
        
    }
    
    public static void escanear(String s, String[][] t, String w){
        for (int i = 0; i < s.length(); i++) {
            CharSequence cs = s.substring(i, i+1);
            if (w.contains(cs)) {
                aumentar(s.substring(i, i+1), t);
            }
        }
    }
    
    public static void aumentar(String c, String[][] t){
        int aux;
        for (int i = 0; i < t.length; i++) {
            if (t[i][0].equalsIgnoreCase(c)) {
                aux = Integer.parseInt(t[i][1]) + 1;
                t[i][1] = aux + "";
            }
        }
    }
    
    public static String quitarAcentos(String s){
        s = Normalizer.normalize(s, Normalizer.Form.NFD);
        s = s.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
        return s;
    }

