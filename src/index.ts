import { registerPlugin } from '@capacitor/core';

import type { BackButtonOverridePlugin } from './definitions';

const BackButtonOverride = registerPlugin<BackButtonOverridePlugin>('BackButtonOverride', {
  web: () => import('./web').then((m) => new m.BackButtonOverrideWeb()),
});

export * from './definitions';
export { BackButtonOverride };
