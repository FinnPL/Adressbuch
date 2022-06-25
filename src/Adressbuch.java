import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Adressbuch {
  private Adresse[] adressbuch = new Adresse[100];
  private int index = 0;

  public String getAdressString(int nr) {
    return adressbuch[nr].toFormatedString() + "\n";
  }

  public void print(int nr) {
    adressbuch[nr].print();
  }

  public void print() {
    for (int i = 0; i < index; i++) {
      adressbuch[i].print();
      System.out.println();
    }
  }

  public void add(Adresse a) {
    if (adressbuch.length > index) {
      adressbuch[index] = a;
    } else {
      adressbuch = getLongeAdressbuch(adressbuch);
      adressbuch[index] = a;
    }
    index++;
  }

  public void save(String path) throws FileNotFoundException {
    PrintWriter out = new PrintWriter(path);
    for (int i = 0; i < index; i++) {
      out.println(adressbuch[i]);
    }
    out.flush();
    out.close();
  }

  public void load(String path) throws FileNotFoundException {
    Scanner scanman = new Scanner(new File(path));
    while (scanman.hasNextLine()) {
      String s = scanman.nextLine();
      String[] str = s.split(";");

      if (str[7] != null) {
        add(new AdresseUK(str[0], str[1], str[2], Integer.parseInt(str[3]), str[4], str[5], str[6], str[7]));
      } else if (str[8] != null) {
        add(new AdresseUS(str[0], str[1], str[2], Integer.parseInt(str[3]), str[4], str[5], str[6], str[8]));
      } else {
        add(new AdresseDE(str[0], str[1], str[2], Integer.parseInt(str[3]), str[4], str[5], str[6]));
      }
    }
  }

  private Adresse[] getLongeAdressbuch(Adresse[] adressbuch) {
    Adresse[] nAdressbuch = new Adresse[index + 100];
    for (int i = 0; i < index; i++) {
      nAdressbuch[i] = adressbuch[i];
    }
    return nAdressbuch;
  }

  public int getIndex() {
    return index;
  }

}