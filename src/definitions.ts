export interface BackButtonOverridePlugin {
  echo(options: { value: string }): Promise<{ value: string }>;
}
