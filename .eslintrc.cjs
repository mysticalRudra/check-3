module.exports = {
  root: true,
  extends: [
    'eslint:recommended',
    'plugin:import/errors',
    'plugin:@typescript-eslint/recommended',
    'plugin:react/recommended',
    'plugin:react/jsx-runtime',
    'plugin:jsx-a11y/recommended',
    'plugin:react-hooks/recommended',
    'prettier'
  ],
  plugins: ['react', 'import', 'jsx-a11y', 'react-refresh'],
  parser: '@typescript-eslint/parser',
  parserOptions: {
    ecmaVersion: 'latest',
    sourceType: 'module',
    ecmaFeatures: {
      jsx: true
    }
  },
  env: {
    es2020: true,
    browser: true,
    node: true
  },
  settings: {
    react: {
      version: 'detect'
    },
    'import/resolver': {
      node: {
        extensions: ['.js', '.jsx', '.ts', '.tsx'],
        moduleDirectory: ['src', 'node_modules']
      },
      typescript: {} // this resolve libraries with multiple entry points
    }
  },
  ignorePatterns: ['dist', '.eslintrc.cjs', '*.css'],
  rules: {
    curly: 'error',
    'max-classes-per-file': ['error', 1],
    'no-alert': 'error',
    'no-await-in-loop': 'error',
    'no-console': ['error', { allow: ['debug', 'warn', 'error', 'time', 'timeEnd', 'trace'] }],
    'no-restricted-imports': ['error', 'rxjs/Rx', 'lodash', 'moment', 'moment-timezone', 'underscore'],
    'no-shadow': ['error', { builtinGlobals: true, hoist: 'functions' }],
    'no-unreachable': 'error',
    'no-unreachable-loop': 'error',
    'no-unused-vars': ['error', { varsIgnorePattern: '^[_]+$' }],
    'no-var': 'error',
    'react/button-has-type': 'error',
    'react/no-array-index-key': 'error',
    'react/jsx-no-target-blank': 'off',
    'react/jsx-uses-react': 'off',
    'react/react-in-jsx-scope': 'off',
    'react-refresh/only-export-components': ['warn', { allowConstantExport: true }]
  },
  overrides: [
    {
      files: ['*.model.ts'],
      rules: {
        'no-unused-vars': 'off'
      }
    }
  ]
};
