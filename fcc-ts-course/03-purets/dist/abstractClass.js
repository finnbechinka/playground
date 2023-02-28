"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
class TakePhoto {
    constructor(mode, filter) {
        this.mode = mode;
        this.filter = filter;
    }
    get_num() {
        return 0;
    }
}
// const x = new TakePhoto("a", "b");
class Insta extends TakePhoto {
    constructor(mode, filter) {
        super(mode, filter);
        this.mode = mode;
        this.filter = filter;
    }
    method() { }
}
