/** @type {import('@ts-jest/dist/types').InitialOptionsTsJest} */
module.exports = {
  preset: 'ts-jest',
  testEnvironment: 'node',

  "roots": [
    "./src",
    "./tests",
  ],

  "testMatch": [
    "./**/*.test.(ts|tsx|js)",
  ],

  "transform": {
    "^.+\\.(ts|tsx)$": "ts-jest"
  },
}
