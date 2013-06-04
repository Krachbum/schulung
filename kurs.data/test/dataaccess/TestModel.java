package dataaccess;

import java.io.Serializable;

public class TestModel implements Serializable {
  /**
	 * 
	 */
  private static final long serialVersionUID = 963160853877176625L;
  String str = "Ich bin ein Test";
  Integer i = 1;

  @Override
  public String toString() {
    return str + i;
  }

  public TestModel(Integer i) {
    super();
    this.i = i;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((i == null) ? 0 : i.hashCode());
    result = prime * result + ((str == null) ? 0 : str.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null) return false;
    if (getClass() != obj.getClass()) return false;
    TestModel other = (TestModel) obj;
    if (i == null) {
      if (other.i != null) return false;
    } else if ( !i.equals(other.i)) return false;
    if (str == null) {
      if (other.str != null) return false;
    } else if ( !str.equals(other.str)) return false;
    return true;
  }

}
