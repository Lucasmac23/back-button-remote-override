export interface BackButtonOverridePlugin {
  echo(options: { value: string }): Promise<{ value: string }>;
  enableOverride(): Promise<void>;
  disableOverride(): Promise<void>;
}
