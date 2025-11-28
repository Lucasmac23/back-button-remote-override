# back-button-remote-override

overrides the back button functionality on the remote. Click twice to leave

## Install

```bash
npm install back-button-remote-override
npx cap sync
```

## API

<docgen-index>

* [`echo(...)`](#echo)
* [`enableOverride()`](#enableoverride)
* [`disableOverride()`](#disableoverride)
* [`addListener('backButtonPressed', ...)`](#addlistenerbackbuttonpressed-)
* [`homeBackPressed()`](#homebackpressed)
* [`exitToHomeScreen()`](#exittohomescreen)

</docgen-index>

<docgen-api>
<!--Update the source file JSDoc comments and rerun docgen to update the docs below-->

### echo(...)

```typescript
echo(options: { value: string; }) => Promise<{ value: string; }>
```

| Param         | Type                            |
| ------------- | ------------------------------- |
| **`options`** | <code>{ value: string; }</code> |

**Returns:** <code>Promise&lt;{ value: string; }&gt;</code>

--------------------


### enableOverride()

```typescript
enableOverride() => Promise<void>
```

--------------------


### disableOverride()

```typescript
disableOverride() => Promise<void>
```

--------------------


### addListener('backButtonPressed', ...)

```typescript
addListener(eventName: 'backButtonPressed', listenerFunc: () => void) => Promise<{ remove: () => void; }>
```

Fired whenever the Android hardware back button is pressed.

| Param              | Type                             |
| ------------------ | -------------------------------- |
| **`eventName`**    | <code>'backButtonPressed'</code> |
| **`listenerFunc`** | <code>() =&gt; void</code>       |

**Returns:** <code>Promise&lt;{ remove: () =&gt; void; }&gt;</code>

--------------------


### homeBackPressed()

```typescript
homeBackPressed() => Promise<{ handled: boolean; }>
```

Trigger the "double press to exit" logic from Angular.

**Returns:** <code>Promise&lt;{ handled: boolean; }&gt;</code>

--------------------


### exitToHomeScreen()

```typescript
exitToHomeScreen() => Promise<{ handled: boolean; }>
```

Allows for exiting the app to the home screen (emulated from intents)

**Returns:** <code>Promise&lt;{ handled: boolean; }&gt;</code>

--------------------

</docgen-api>
