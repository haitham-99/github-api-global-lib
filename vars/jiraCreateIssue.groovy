def call(Map config=[:]) {
  def rawBody = libraryResource 'com/planetpope/api/jira/createIssue.json'
  def binding = [
    key: "${config.key}",
    summary: "${config.summary}",
    description: "${config.description}",
    issueTypeName: "${config.issueTypeName}"
  ]
  def render = renderTemplate(rawBody,binding)
  bat('curl -D- -u haithamodehodeh@gmail.com:uZVMWwRxMQt07TyYDPTE09A3 -X POST --data "'+render+'" -H "Content-Type: application/json" https://testecom.atlassian.net/rest/api/2/issue')
}
