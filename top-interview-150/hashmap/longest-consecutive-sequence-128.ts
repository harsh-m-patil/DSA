// also we can sort the array and iterate over it instead of using a set
function longestConsecutive(nums: number[]): number {
  const set = new Set<number>();
  let answer = 1;

  for (const num of nums) {
    set.add(num);
  }

  for (const num of set) {
    let l = 0;
    let next = num;
    if (!set.has(num - 1)) {
      while (set.has(next)) {
        l++;
        next++;
      }
    }

    answer = Math.max(answer, l);
  }

  return answer;
}
