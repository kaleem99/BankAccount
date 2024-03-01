package bankaccount;

public class User {

  private String name;
  private String surname;
  private String email;
  private String idNumber;
  private String CellNumber;
  private String AccountType;
  private String Amount;
  private String code;

  User(
    String name,
    String surname,
    String email,
    String idNumber,
    String CellNumber,
    String AccountType,
    String Amount,
    String code
  ) {
    this.name = name;
    this.surname = surname;
    this.email = email;
    this.idNumber = idNumber;
    this.CellNumber = CellNumber;
    this.AccountType = AccountType;
    this.Amount = Amount;
    this.code = code;
  }

  public String createJsonObject() {
    return (
      "{" +
      "\"name\":\"" +
      name +
      "\"," +
      "\"surname\":\"" +
      surname +
      "\"," +
      "\"email\":\"" +
      email +
      "\"," +
      "\"idNumber\":\"" +
      idNumber +
      "\"," +
      "\"CellNumber\":\"" +
      CellNumber +
      "\"," +
      "\"AccountType\":\"" +
      AccountType +
      "\"," +
      "\"Amount\":\"" +
      Amount +
      "\"," +
      "\"code\":\"" +
      code +
      "\"" +
      "}"
    );
  }
}
