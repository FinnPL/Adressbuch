public class AdresseUS extends Adresse {
  private String State;

  @Override
  public void print() {
    System.out.println(getName() + " " + getNName() + " \n" + getHnummer() + " " + getStrase() + " \n" + getOrt() + ", "
        + getState() + " " + getPlz() + " \n" + getLand());
  }

  public String getState() {
    return State;
  }

}
