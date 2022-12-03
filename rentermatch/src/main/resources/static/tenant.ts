import {client} from "./client";

export class tenant extends client {

  constructor(
      public username: string,
      public password: string,
      public Email: string,
      public tPhone: string,
      public tGender: string,
      public tAge: number,
      public tConstellation: string,
      public tJob: string,
      public tPreferLocation: string,
      public tPreferZipCode: number,
      public tPreferType: string,
      public tExpenditure: number,
      public tNumOfRoomates: number,
      public tSmoking: string,
      public tPet: string,
      public tCooking: string,
      public tEarlyTimeSleep: string,
      public tLateTimeSleep: string,
      public uni: string
  ) {
    super(username, password, Email);
  }

}

export interface tenantRsp {
  data: tenant
}
