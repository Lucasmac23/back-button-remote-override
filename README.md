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

</docgen-api>
