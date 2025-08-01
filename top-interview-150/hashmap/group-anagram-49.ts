function groupAnagrams(strs: string[]): string[][] {
  // sorted word will be the key
  const map = new Map<string, string[]>();
  const res: string[][] = [];

  for (const str of strs) {
    const key = str.split("").sort().join();
    if (!map.has(key)) {
      map.set(key, [str]);
    } else {
      map.set(key, [str, ...map.get(key)!]);
    }
  }

  for (const values of map.values()) {
    res.push(values);
  }

  return res;
}
