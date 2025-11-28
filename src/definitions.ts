export interface BackButtonOverridePlugin {
  echo(options: { value: string }): Promise<{ value: string }>;
  enableOverride(): Promise<void>;
  disableOverride(): Promise<void>;

  /**
   * Fired whenever the Android hardware back button is pressed.
   */
  addListener(eventName: 'backButtonPressed', listenerFunc: () => void): Promise<{ remove: () => void }>;

  /**
   * Trigger the "double press to exit" logic from Angular.
   */
  homeBackPressed(): Promise<{ handled: boolean }>;
  /**
   * Allows for exiting the app to the home screen (emulated from intents)
   */
  exitToHomeScreen(): Promise<{ handled: boolean }>;
}
