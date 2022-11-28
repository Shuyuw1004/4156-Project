export class client {

        constructor(public username: string,
                    public password: string,
                    public Email: string) {}
      
      }
      
      export interface clientRsp {
        data: client
      }
      