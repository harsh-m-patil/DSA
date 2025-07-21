// using a map
// O(n)
function majorityElementMap(nums: number[]): number {
  const map = new Map<number, number>();

  for (let num of nums) {
    if (map.has(num)) {
      map.set(num, map.get(num)! + 1);
    } else {
      map.set(num, 1);
    }
  }

  for (let [key, val] of map) {
    if (val > nums.length / 2) {
      return key;
    }
  }

  return 0;
}

// O(1) Optimal Solution
function majorityElement(nums: number[]): number {
  let candidate = 0;
  let count = 0;

  for (const num of nums) {
    if (count === 0) candidate = num;
    if (num === candidate) count++;
    else {
      count--;
    }
  }

  return candidate;
}
