# AGENTS.md

## Build, Lint, and Test Commands
- **Test all (binary-tree/linked-list):** `cd implementation/binary-tree && bun run test` or `cd implementation/linked-list && bun run test`
- **Run a single test:** Use `vitest test <file>` in the respective directory
- **Typecheck:** `bunx tsc --noEmit` (strict mode enabled)
- **Lint:** No linter configured by default

## Code Style Guidelines
- **Languages:** TypeScript (ESNext), JavaScript, Java
- **Imports:** Use ES module syntax; import types with `import type` if needed
- **Formatting:** 2 spaces, no semicolons required, trailing commas optional
- **Types:** Prefer explicit types, use `Record`, `string[]`, etc. for structures
- **Naming:** camelCase for variables/functions, PascalCase for types/classes
- **Error Handling:** Use non-null assertions only when safe; avoid try/catch unless necessary
- **Testing:** Use Vitest for TypeScript/JS; test files end with `.test.ts`
- **Strictness:** TypeScript strict mode, skipLibCheck, no fallthrough in switch, noUncheckedIndexedAccess
- **Java:** Standard Java conventions for DSA/algorithms
- **No Cursor or Copilot rules detected**

## Notes
- Place new TypeScript/JS code in the appropriate implementation subfolder
- Follow existing patterns for data structures and algorithms
- See README.md for Java DSA patterns and idioms
