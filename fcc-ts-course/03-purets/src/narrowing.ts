function detect_type(val: number | string) {
  if (typeof val === "string") {
    return val.toLocaleLowerCase();
  }
  return val + 3;
}

function provide_id(id: string | null) {
  if (!id) {
    console.log("haha");
    return;
  }
  return id.toLocaleLowerCase();
}
