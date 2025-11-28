import { WebPlugin } from '@capacitor/core';

import type { BackButtonOverridePlugin } from './definitions';

export class BackButtonOverrideWeb extends WebPlugin implements BackButtonOverridePlugin {
  async echo(options: { value: string }): Promise<{ value: string }> {
    console.log('ECHO', options);
    return options;
  }

  enableOverride(): any {
    console.warn('not implemented on web');
    return;
  }
  disableOverride(): any {
    console.warn('not implemented on web');
    return;
  }

  addListener(): any {
    console.log('not implemented on web');
    return null as any;
  }

  homeBackPressed(): any {
    console.log('not implemented on web');
    return;
  }

  exitToHomeScreen(): any {
    console.log('not implemented on web');
    return;
  }
}
