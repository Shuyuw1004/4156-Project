import { landlord } from "./landlord";

export class house extends landlord {

        constructor(
                public username: string,
                public password: string,
                public Email: string,
                public lPhone: string,
                public hAddress: string,
                public hPrice: number,
                public hType: string,
                
                ) {
                super(username,password,Email,lPhone);
        }
      
      }
      
      export interface houseRsp {
        data: house
      }