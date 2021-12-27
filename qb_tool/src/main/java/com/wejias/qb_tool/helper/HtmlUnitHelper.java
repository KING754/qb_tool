res Node.js 8.6 or higher. Please let us know if you need support for an earlier version by creating an [issue](../../issues/new).)_

<br>

## ❯ Usage

### Single prompt

The easiest way to get started with enquirer is to pass a [question object](#prompt-options) to the `prompt` method.

```js
const { prompt } = require('enquirer');

const response = await prompt({
  type: 'input',
  name: 'username',
  message: 'What is your username?'
});

console.log(response); // { username: 'jonschlinkert' }
```

_(Examples with `await` need to be run inside an `async` function)_

### Multiple prompts

Pass an array of ["question" objects](#prompt-options) to run a series of prompts.

```js
const response = await prompt([
  {
    type: 'input',
    name: 'name',
    message: 'What is your name?'
  },
  {
    type: 'input',
    name: 'username',
    message: 'What is your username?'
  }
]);

console.log(response); // { name: 'Edward Chan', username: 'edwardmchan' }
```

### Different ways to run enquirer

#### 1. By importing the specific `built-in prompt`

```js
const { Confirm } = require('enquirer');

const prompt = new Confirm({
  name: 'question',
  message: 'Did you like enquirer?'
});

prompt.run()
  .then(answer => console.log('Answer:', answer));
```

#### 2. By passing the options to `prompt`

```js
const { prompt } = require('enquirer');

prompt({
  type: 'confirm',
  name: 'question',
  message: 'Did you like enquirer?'
})
  .then(answer => console.log('Answer:', answer));
```

**Jump to**: [Getting Started](#-getting-started) · [Prompts](#-prompts) · [Options](#-options) · [Key Bindings](#-key-bindings)

<br>

## ❯ Enquirer

**Enquirer is a prompt runner**

Add Enquirer to your JavaScript project with following line of code.

```js
const Enquirer = require('enquirer');
```

The main export of this library is the `Enquirer` class, which has methods and features designed to simplify running prompts.

```js
const { prompt } = require('enquirer');
const question = [
  {
    type: 'input',
    name: 'username',
    message: 'What is your username?'
  },
  {
    type: 'password',
    name: 'password',
    message: 'What is your password?'
  }
];

let answers = await prompt(question);
console.log(answers);
```

**Prompts control how values are rendered and returned**

Each individual prompt is a class with special features and functionality for rendering the types of values you want to show users in the terminal, and subsequently returning the types of values you need to use in your application.

**How can I customize prompts?**

Below in this guide you will find information about creating [custom prompts](#-custom-prompts). For now, we'll focus on how to customize an existing prompt.

All of the individual [prompt classes](#built-in-prompts) in this library are exposed as static properties on Enquirer. This allows them to be used directly without using `enquirer.prompt()`.

Use this approach if you need to modify a prompt instance, or listen for events on the prompt.

**Example**

```js
const { Input } = require('enquirer');
const prompt = new Input({
  name: 'username',
  message: 'What is your username?'
});

prompt.run()
  .then(answer => console.log('Username:', answer))
  .catch(console.error);
```

### [Enquirer](index.js#L20)

Create an instance of `Enquirer`.

**Params**

* `options` **{Object}**: (optional) Options to use with all prompts.
* `answers` **{Object}**: (optional) Answers object to initialize with.

**Example**

```js
const Enquirer = require('enquirer');
const enquirer = new Enquirer();
```

### [register()](index.js#L42)

Register a custom prompt type.

**Params**

* `type` **{String}**
* `fn` **{Function|Prompt}**: `Prompt` class, or a function that returns a `Prompt` class.
* `returns` **{Object}**: Returns the Enquirer instance

**Example**

```js
const Enquirer = require('enquirer');
const enquirer = new Enquirer();
enquirer.register('customType', require('./custom-prompt'));
```

### [prompt()](index.js#L78)

Prompt function that takes a "question" object or array of question objects, and returns an object with responses from the user.

**Params**

* `questions` **{Array|Object}**: Options objects for one or more prompts to run.
* `returns` **{Promise}**: Promise that returns an "answers" object with the user's responses.

**Example**

```js
const Enquirer = require('enquirer');
const enquirer = new Enquirer();

const response = await enquirer.prompt({
  type: 'input',
  name: 'username',
  message: 'What is your username?'
});
console.log(response);
```

### [use()](index.js#L160)

Use an enquirer plugin.

**Params**

* `plugin` **{Function}**: Plugin function that takes an instance of Enquirer.
* `returns` **{Object}**: Returns the Enquirer instance.

**Example**

```js
const Enquirer = require('enquirer');
const enquirer = new Enquirer();
const plugin = enquirer => {
  // do stuff to enquire instance
};
enquirer.use(plugin);
```

### [Enquirer#prompt](index.js#L210)

Prompt function that takes a "question" object or array of question objects, and returns an object with responses from the user.

**Params**

* `questions` **{Array|Object}**: Options objects for one or more prompts to run.
* `returns` **{Promise}**: Promise that returns an "answers" object with the user's responses.

**Example**

```js
const { prompt } = require('enquirer');
const response = await prompt({
  type: 'input',
  name: 'username',
  message: 'What is your username?'
});
console.log(response);
```

<br>

## ❯ Prompts

This section is about Enquirer's prompts: what they look like, how they work, how to run them, available options, and how to customize the prompts or create your own prompt concept.

**Getting started with Enquirer's prompts**

* [Prompt](#prompt) - The base `Prompt` class used by other prompts
  - [Prompt Options](#prompt-options)
* [Built-in prompts](#built-in-prompts)
* [Prompt Types](#prompt-types) - The base `Prompt` class used by other prompts
* [Custom prompts](#%E2%9D%AF-custom-prompts) - Enquirer 2.0 introduced the concept of prompt "types", with the goal of making custom prompts easier than ever to create and use.

### Prompt

The base `Prompt` class is used to create all other prompts.

```js
const { Prompt } = require('enquirer');
class MyCustomPrompt extends Prompt {}
```

See the documentation for [creating custom prompts](#-custom-prompts) to learn more about how this works.

#### Prompt Options

Each prompt takes an options object