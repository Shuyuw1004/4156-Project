import {Client} from "../register/client";

export class Realtor extends Client {
  constructor(name: string = "", password: string = "", email: string = "") {
    super(name, password, email);
  }
}
