"use strict";
function detect_type(val) {
    if (typeof val === "string") {
        return val.toLocaleLowerCase();
    }
    return val + 3;
}
function provide_id(id) {
    if (!id) {
        console.log("haha");
        return;
    }
    return id.toLocaleLowerCase();
}
