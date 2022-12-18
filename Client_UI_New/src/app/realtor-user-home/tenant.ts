export class Tenant{
  header : String[];
  elements : String[];
  constructor(textNeedToParse : string) {
    let newText = textNeedToParse.substring(7, textNeedToParse.length-1);
    this.header = [];
    this.elements = [];
    for (let index = 0; index < newText.split(",").length; index++){
      let stringElement = newText.split(",")[index];
      if (stringElement.split("=")[0] !== " password" &&
        stringElement.split("=")[0] !== "cid") {
        this.header.push(stringElement.split("=")[0]);
        this.elements.push(stringElement.split("=")[1]);
      }
    }
  }
}
