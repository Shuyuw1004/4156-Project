import {Client} from "../register/client";

export class Landlord extends Client {

  public phone: string;

  constructor(name: string = "", password: string = "", email: string = "", phone: string = "") {
    super(name, password, email);
    this.phone = phone;
  }
}
