import { client } from "./client";

export class landlord extends client {

        constructor(
                public username: string,
                public password: string,
                public Email: string,
                public lPhone: string) {
                super(username,password,Email);
        }
      
      }
      
      export interface landlordRsp {
        data: landlord
      }