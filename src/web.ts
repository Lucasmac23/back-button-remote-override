import { WebPlugin } from '@capacitor/core';

import type { BackButtonOverridePlugin } from './definitions';

export class BackButtonOverrideWeb extends WebPlugin implements BackButtonOverridePlugin {
  async echo(options: { value: string }): Promise<{ value: string }> {
    console.log('ECHO', options);
    return options;
  }
}
