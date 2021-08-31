# DGrocery

A simple grocery app connected to the [grocery orbit dapp project](https://github.com/BitFis/groccery-orbitdb-dapp).

## CICD

Auto deployed with [fastlane](https://fastlane.tools/).

> [Do it yourself, checkout this blog.](https://medium.com/scalereal/automate-publishing-app-to-the-google-play-store-with-github-actions-fastlane-ac9104712486)

### Prepare

1. Create a keystore for signing: like:"
  - `keytool -v -genkey -keystore release.keystore -alias dgrocery -keyalg RSA -validity 10000`
  - configure in `~/.gradle/gradle.properties` or set as environment variables:
    ```
    APP_CONFIG_RELEASE_STOREFILE={path to your keystore}
    APP_CONFIG_RELEASE_STORE_PASSWORD=*****
    APP_CONFIG_RELEASE_STORE_ALIAS=*****
    APP_CONFIG_RELEASE_STORE_KEY_PASSWORD=*****
    ```
    > `APP_CONFIG_RELEASE_STORE_KEY_PASSWORD` takes default value from `APP_CONFIG_RELEASE_STORE_PASSWORD`
    >
    > `APP_CONFIG_RELEASE_STORE_ALIAS` default value is `key0`
2. [Prepare play_config.json file for upload](https://docs.fastlane.tools/actions/supply/#setup)
3. Build release `./gradlew clean bundleRelease`

### Locally

Setup (on debian / ubuntu, but windows should work aswell, depends on [ruby and dependencies](https://github.com/rbenv/ruby-build/wiki#suggested-build-environment)):

```bash
# install deps
sudo apt-get install autoconf bison build-essential libssl-dev libyaml-dev libreadline6-dev zlib1g-dev libncurses5-dev libffi-dev libgdbm6 libgdbm-dev libdb-dev

sudo gem install fastlane -NV

# prepare play_config.json file
echo WIP

# check play_condfig.json file
fastlane run validate_play_store_json_key json_key:play_config.json

# check aab is signed
jarsigner -verify ./app/build/outputs/bundle/release/app-release.aab

# upload built bundle (using internal track, other tracks: beta / )
fastlane supply --aab ./app/build/outputs/bundle/release/app-release.aab --track internal
```

### Github Actions

WIP
