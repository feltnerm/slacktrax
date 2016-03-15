# slacktrax

FIXME: description

## Requirements

- lein
- A [Slack Webhook URL](https://widen.slack.com/apps/new/A0F7XDUAZ-incoming-webhooks) token

## Usage

### AWS Lambda

FIXME: explanation

### Standalone

FIXME: explanation

`lein run -m slacktrax.core -- $SLACK_TOKEN $SLACK_CHANNEL $TIMEAGO_VAL $TIMEAGO_INTERVAL`

### Development

FIXME: explanation

`lein repl`

```clojure
user=> (dev)
user=> (go)      ;; runs the `slacktrax.core/-main` method
user=> (restart) ;; refreshes the code (any imports or changes) and re-runs main
```

### Tests

`lein test`

#### REPL-driven testing

`lein repl`

```clojure
user=> (dev)
user=> (go-test)      ;; runs the `slacktrax.core/-main` method
user=> (restart-test) ;; refreshes the code (any imports or changes) and re-runs main
```

### Potential Features

...

## License

Copyright © 2016 Mark Feltner

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
